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

    public  static Student[] studentArray  = new Student[] {
        new Student("PR24105001", "199501012345", "Gunawardena Weerasinghe", 85, 66),
        new Student("PR24105002", "199503153872", "Senanayake Silva", 39, 45),
        new Student("PR24105003", "199506202198", "Silva Kumara", -1, 93),
        new Student("PR24105004", "199509102983", "Kumara Herath", 72, 58),
        new Student("PR24105005", "199511258739", "Rathnayake Herath", 44, -1),
        new Student("PR24105006", "199512303498", "Wijesinghe Bandara", 91, 37),
        new Student("PR24105007", "199502183764", "Rajapaksha Herath", 60, 88),
        new Student("PR24105008", "199504223198", "Senanayake Karunaratne", 38, 21),
        new Student("PR24105009", "199508153210", "Karunaratne Jayasinghe", 95, 79),
        new Student("PR24105010", "199510293417", "Gunawardena Silva", 49, 40),
        new Student("OR24105011", "199601102375", "Weerasinghe Rajapaksha", -1, 76),
        new Student("OR24105012", "199604182938", "Silva Rathnayake", 67, 54),
        new Student("OR24105013", "199606243879", "Fernando Perera", 23, -1),
        new Student("OR24105014", "199608142178", "Kumara Abeysekera", 58, 69),
        new Student("OR24105015", "199610312475", "Ekanayake Rathnayake", 88, 92),
        new Student("PR24105016", "199611173452", "Ekanayake Rathnayake", 81, 25),
        new Student("PR24105017", "199603293481", "Herath Gunawardena", 73, 84),
        new Student("PR24105018", "199605083217", "Abeysekera Silva", 29, 33),
        new Student("OR24105019", "199607232198", "Weerasinghe Silva", 62, 60),
        new Student("OR24105020", "199609192375", "Jayasinghe Dias", -1, 71),
        new Student("PR24105021", "199701212483", "Bandara Rathnayake", 79, 59),
        new Student("PR24105022", "199703132487", "Silva Perera", 53, -1),
        new Student("OR24105023", "199706253478", "De Silva Dias", 94, 98),
        new Student("OR24105024", "199708083298", "Abeysekera Jayasinghe", 47, 27),
        new Student("PR24105025", "199710243651", "Rajapaksha Senanayake", 35, 48),
        new Student("PR24106001", "199712152983", "Kumara Karunaratne", 93, 35),
        new Student("PR24106002", "199702182734", "Silva Abeysekera", 15, 91),
        new Student("PR24106003", "199704293187", "Jayasinghe Bandara", -1, 60),
        new Student("PR24106004", "199705142375", "Rathnayake Kumara", 82, -1),
        new Student("PR24106005", "199709083751", "Weerasinghe Rajapaksha", 45, 72),
        new Student("PR24106006", "199801032874", "Senanayake Herath", 88, 49),
        new Student("PR24106007", "199803232871", "Perera Ekanayake", 23, 26),
        new Student("PR24106008", "199806193428", "Herath Jayasinghe", 79, 80),
        new Student("PR24106009", "199808013764", "Kumara Gunawardena", 37, 14),
        new Student("PR24106010", "199810242374", "Abeysekera Silva", -1, 89),
        new Student("OR24106011", "199812302984", "Dias Fernando", 68, 67),
        new Student("OR24106012", "199802152348", "Karunaratne Weerasinghe", 100, -1),
        new Student("OR24106013", "199805213471", "Ekanayake Bandara", 59, 31),
        new Student("OR24106014", "199807172398", "Rajapaksha Kumara", 29, 94),
        new Student("OR24106015", "199811283472", "Silva De Silva", 92, 53),
        new Student("PR24106016", "199901122471", "Gunawardena Rathnayake", 12, 78),
        new Student("PR24106017", "199903052984", "Bandara Karunaratne", 77, 5),
        new Student("PR24106018", "199906213874", "Fernando Perera", 38, 90),
        new Student("OR24106019", "199908093412", "De Silva Silva", 66, 24),
        new Student("OR24106020", "199910273894", "Rajapaksha Gunawardena", 9, 86),
        new Student("PR24106021", "199912153482", "Herath Weerasinghe", 84, 39),
        new Student("PR24106022", "199902202394", "Karunaratne Dias", 51, -1),
        new Student("OR24106023", "199904163874", "Jayasinghe Silva", 32, 61),
        new Student("OR24106024", "199907293481", "Senanayake Abeysekera", -1, 73),
        new Student("PR24106025", "199911083479", "Silva Jayasinghe", 97, 100),
        new Student("PR24107001", "200001112374", "Rathnayake Kumara", 95, 38),
        new Student("PR24107002", "200003143478", "Gunawardena Kumara", -1, 91),
        new Student("PR24107003", "200006293874", "Rajapaksha Silva", 63, -1),
        new Student("PR24107004", "200008103471", "Perera Jayasinghe", 88, 74),
        new Student("PR24107005", "200010252984", "Silva Ekanayake", 32, 55),
        new Student("PR24107006", "200012043894", "Dias Senanayake", 76, 82),
        new Student("PR24107007", "200002193874", "Herath Abeysekera", 97, 66),
        new Student("PR24107008", "200004212374", "Rathnayake Fernando", 54, 49),
        new Student("PR24107009", "200005183492", "Kumara Herath", -1, 99),
        new Student("PR24107010", "200007153871", "Weerasinghe Silva", 23, 13),
        new Student("OR24107011", "200101232984", "Senanayake Karunaratne", 90, 80),
        new Student("OR24107012", "200103083471", "Abeysekera Silva", 35, 70),
        new Student("OR24107013", "200106273894", "Bandara Gunawardena", 81, 93),
        new Student("OR24107014", "200108123984", "Karunaratne Weerasinghe", 61, 36),
        new Student("OR24107015", "200110043728", "Perera Herath", 44, 59),
        new Student("PR24107016", "200112213874", "Fernando Dias", 67, 85),
        new Student("PR24107017", "200102253471", "Weerasinghe Gunawardena", 100, 47),
        new Student("PR24107018", "200104103874", "Rathnayake Kumara", 17, 90),
        new Student("OR24107019", "200105293784", "Senanayake Fernando", 85, -1),
        new Student("OR24107020", "200107202983", "Silva Bandara", 29, 22),
        new Student("PR24107021", "200201013874", "Herath Rajapaksha", 70, 77),
        new Student("PR24107022", "200203253471", "Kumara Jayasinghe", 42, 34),
        new Student("OR24107023", "200206143874", "Abeysekera Perera", -1, 63),
        new Student("OR24107024", "200208083471", "Rathnayake Jayasinghe", 60, 100),
        new Student("PR24107025", "200210293874", "Kumara Weerasinghe", 86, 29),
        new Student("PR24108001", "200212183471", "Rajapaksha Ekanayake", 86, 79),
        new Student("PR24108002", "200202103874", "Fernando Rajapaksha", 57, 62),
        new Student("PR24108003", "200204123894", "Silva Gunawardena", 91, 87),
        new Student("PR24108004", "200205283471", "Perera Wijesinghe", 35, -1),
        new Student("PR24108005", "200207153874", "Herath Abeysekera", -1, 54),
        new Student("PR24108006", "200301093874", "Rajapaksha Ekanayake", 76, 46),
        new Student("PR24108007", "200303283471", "Karunaratne Silva", 48, 99),
        new Student("PR24108008", "200306153874", "Weerasinghe Fernando", 94, 39),
        new Student("PR24108009", "200308123471", "Silva Bandara", 23, 70),
        new Student("PR24108010", "200310083874", "Abeysekera Weerasinghe", 69, -1),
        new Student("OR24108011", "200312243471", "Kumara Karunaratne", -1, 75),
        new Student("OR24108012", "200302273874", "Dias Rajapaksha", 80, 83),
        new Student("OR24108013", "200304203471", "Herath Perera", 55, 58),
        new Student("OR24108014", "200305123874", "Rathnayake Gunawardena", 88, 92),
        new Student("OR24108015", "200307213471", "Ekanayake Jayasinghe", 32, 30),
        new Student("PR24108016", "200401153874", "Gunawardena Silva", 100, 91),
        new Student("PR24108017", "200403123471", "Rajapaksha Perera", 67, 40),
        new Student("PR24108018", "200406293874", "Karunaratne Jayasinghe", 43, 63),
        new Student("OR24108019", "200408083471", "Weerasinghe Abeysekera", -1, 95),
        new Student("OR24108020", "200410213874", "Rathnayake Fernando", 90, 68),
        new Student("PR24108021", "200412153471", "Kumara Herath", 60, -1),
        new Student("PR24108022", "200402203874", "Silva Weerasinghe", 77, 66),
        new Student("OR24108023", "200404273471", "Herath Karunaratne", 25, 21),
        new Student("OR24108024", "200405143874", "Abeysekera Silva", 71, 88),
        new Student("PR24108025", "200407183471", "Gunawardena Ekanayake", 84, 37),
        new Student("PR24109001", "200501023874", "Weerasinghe Kumara", 92, 67),
        new Student("PR24109002", "200503193471", "Weerasinghe Kumara", 68, 91),
        new Student("PR24109003", "200506153874", "Rajapaksha Abeysekera", 59, 85),
        new Student("PR24109004", "200508213471", "Gunawardena Perera", 85, 73),
        new Student("PR24109005", "200510083874", "Karunaratne Silva", 63, 70),
        new Student("PR24109006", "200512293471", "Herath Wijesinghe", 76, 63),
        new Student("PR24109007", "200502123874", "Rathnayake Ekanayake", 91, 76),
        new Student("PR24109008", "200504153471", "Silva Fernando", 70, 88),
        new Student("PR24109009", "200505283874", "Abeysekera Rajapaksha", 84, 55),
        new Student("PR24109010", "200507173471", "Fernando Bandara", 63, 64),
        new Student("OR24109011", "200203456782", "Perera Herath", 72, 79),
        new Student("OR24109012", "200305678901", "Weerasinghe Jayasinghe", 89, 80),
        new Student("OR24109013", "199601234567", "Silva Karunaratne", 45, 59),
        new Student("OR24109014", "199511223344", "Rathnayake Gunawardena", 81, 92),
        new Student("OR24109015", "200412345678", "Herath Kumara", 77, 68),
        new Student("PR24109016", "200512345678", "Abeysekera Silva", 68, 100),
        new Student("PR24109017", "199909876543", "Ekanayake Bandara", 63, 77),
        new Student("PR24109018", "199812346789", "Rajapaksha Fernando", 88, 83),
        new Student("OR24109019", "200010203040", "Gunawardena Weerasinghe", 75, 45),
        new Student("OR24109020", "200608789012", "Kumara Karunaratne", 90, 62),
        new Student("PR24109021", "200012345678", "Silva Dias", 57, 66),
        new Student("PR24109022", "199812345679", "Perera Weerasinghe", 79, 59),
        new Student("OR24109023", "199902345678", "Karunaratne Rajapaksha", 92, 78),
        new Student("OR24109024", "199712345670", "Jayasinghe Silva", 62, 85),
        new Student("PR24109025", "200102345671", "Rathnayake Perera", 100, 56),
        new Student("PR24110001", "200203456782", "Silva Ekanayake", -2, -2),
        new Student("PR24110002", "200305678901", "Silva Karunaratne", -2, -2),
        new Student("PR24110003", "199601234567", "Herath Fernando", -2, -2),
        new Student("PR24110004", "199511223344", "Kumara Jayasinghe", -2, -2),
        new Student("PR24110005", "200412345678", "Weerasinghe Perera", -2, -2),
        new Student("PR24110006", "200512345678", "Abeysekera Rajapaksha", -2, -2),
        new Student("PR24110007", "199909876543", "Rathnayake Karunaratne", -2, -2),
        new Student("PR24110008", "199812346789", "Ekanayake Bandara", -2, -2),
        new Student("PR24110009", "200010203040", "Gunawardena Perera", -2, -2),
        new Student("PR24110010", "200608789012", "Silva Wijesinghe", -2, -2),
        new Student("OR24110011", "200012345678", "Rajapaksha Jayasinghe", -2, -2),
        new Student("OR24110012", "199812345679", "Rathnayake Fernando", -2, -2),
        new Student("OR24110013", "199902345678", "Karunaratne Kumara", -2, -2),
        new Student("OR24110014", "199712345670", "Perera Silva", -2, -2),
        new Student("OR24110015", "200102345671", "Gunawardena Ekanayake", -2, -2),
        new Student("PR24110016", "200203456782", "Bandara Rajapaksha", -2, -2),
        new Student("PR24110017", "200305678901", "Silva Herath", -2, -2),
        new Student("PR24110018", "199601234567", "Rathnayake Weerasinghe", -2, -2),
        new Student("OR24110019", "199511223344", "Perera Gunawardena", -2, -2),
        new Student("OR24110020", "200412345678", "Herath Karunaratne", -2, -2),
        new Student("PR24110021", "200203456782", "Silva Rajapaksha", -2, -2),
        new Student("PR24110022", "200305678901", "Ekanayake Kumara", -2, -2),
        new Student("OR24110023", "199601234567", "Bandara Herath", -2, -2),
        new Student("OR24110024", "199511223344", "Weerasinghe Rajapaksha", -2, -2),
        new Student("PR24110025", "200412345678", "Karunaratne Abeysekera", -2, -2)
    };

    public static Student[] getStudentArray() {
    return studentArray;
    }

    public double getBatchNo() {
    return Integer.parseInt(regNo.substring(4, 7));
    }
}