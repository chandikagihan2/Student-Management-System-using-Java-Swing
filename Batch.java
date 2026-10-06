class Batch{
    private int batchNo;
    private int status;

    public Batch(int batchNo, int status) {
        this.batchNo = batchNo;
        this.status = status;
    }

    public Batch(int batchNo) {
        this.batchNo = batchNo;
    }

    public int getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(int batchNo) {
        this.batchNo = batchNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static final int ENROLLMENT_OPEN = 1;
    public static final int ENROLLMENT_CLOSED = 0;

    public static Batch[] batchNameArray = { 
        new Batch(105, ENROLLMENT_CLOSED),
        new Batch(106, ENROLLMENT_CLOSED),
        new Batch(107, ENROLLMENT_CLOSED),
        new Batch(108, ENROLLMENT_CLOSED),
        new Batch(109, ENROLLMENT_OPEN),
        new Batch(110, ENROLLMENT_OPEN) 
    };

    public static Batch[] getBatchNameArray() {
        return batchNameArray;
    }

    public static void addBatch(Batch newBatch) {
        for (int i = 0; i < batchNameArray.length; i++) {
            if (batchNameArray[i] == null) {
                batchNameArray[i] = newBatch;
                return;
            }
        }
    }
}
