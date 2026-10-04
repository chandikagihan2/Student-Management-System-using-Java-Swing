class Batch{
    private int batchNo;
    private int status;

    public Batch(int batchNo, int status) {
        this.batchNo = batchNo;
        this.status = status;
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
}
