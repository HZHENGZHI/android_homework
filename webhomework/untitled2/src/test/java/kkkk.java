public class kkkk {
    static class IOperationLog{
        boolean write()
        {
            System.out.println("writeLog");
            return true;}
    }
    class TxFileLog extends IOperationLog
    {
        boolean write()
        {
            System.out.println("TxFileLog writeLog");
            return true;
        }

    }
    static class BinaryFileLog extends IOperationLog
    {
        boolean write()
        {
            System.out.println("BinaryFileLog writeLog");
            return true;
        }
    }
    static class NewLog
    {
        boolean write()
        {
            System.out.println("NewLog write");
            return true;
        }
    }

    static class logAdapter extends IOperationLog
    {
        private int k;
        NewLog log;
        public logAdapter(int k)
        {
            k=this.k;
        }
        public boolean write()
        {
            System.out.println("newlog ");
            return true;
        }
    }

    public static void main(String[] args) {
        IOperationLog log= new BinaryFileLog();
        log=new logAdapter(1);
        log.write();
    }

}
