class Student{
	private String regNo;
	private String nic;
	private String name;
    private int prfMarks;
    private int dbmsMarks;

    public Student(String regNo, String nic, String name, int prfMarks, int dbmsMarks) {
        this.regNo = regNo;
        this.nic = nic;
        this.name = name;
        this.prfMarks = prfMarks;
        this.dbmsMarks = dbmsMarks;
    }
    //getters
    public String getRegNo() {
        return regNo;
    }

    public String getNic() {
        return nic;
    }

    public String getName() {
        return name;
    }

    public int getPrfMarks() {
        return prfMarks;
    }

    public int getDbmsMarks() {
        return dbmsMarks;
    }
    //setters
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrfMarks(int prfMarks) {
        this.prfMarks = prfMarks;
    }

    public void setDbmsMarks(int dbmsMarks) {
        this.dbmsMarks = dbmsMarks;
    }

    public double getGPA() {
        double prfGPA = 0.0; // Assuming PRF marks are out of 100
        double dbmsGPA = 0.0;

        if (prfMarks >=0) {
            int [] ranges = {90, 80, 75, 70, 65, 60, 55, 50, 45, 40, 30, 20};
            double [] gpaValues = {4.25, 4.00, 3.70, 3.30, 3.00, 2.70, 2.30, 2.00, 1.70, 1.30, 1.00, 0.70};
        for (int i = 0; i < ranges.length; i++) {
            if (prfMarks >= ranges[i]) {
                prfGPA = gpaValues[i];
                break;
            }
        }
    }
        if (dbmsMarks >=0) {
            int [] ranges = {90, 80, 75, 70, 65, 60, 55, 50, 45, 40, 30, 20};
            double [] gpaValues = {4.25, 4.00, 3.70, 3.30, 3.00, 2.70, 2.30, 2.00, 1.70, 1.30, 1.00, 0.70};
        for (int i = 0; i < ranges.length; i++) {
            if (dbmsMarks >= ranges[i]) {
                dbmsGPA = gpaValues[i];
                break;
            }
        }    
	}
            return (prfGPA + dbmsGPA) / 2.0;
	
	}
}