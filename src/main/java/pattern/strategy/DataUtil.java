package pattern.strategy;

/**
 * 数据处理工具类
 * @param <T>
 */
public class DataUtil<T> {

    private volatile static DataUtil INSTANCE = null;

    private DataUtil() {

    }


    public  static DataUtil getInstance() {

        if (INSTANCE == null) {
            synchronized (DataUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DataUtil();
                }
            }
        }
        return INSTANCE;
    }


    private IReadWrite<T> iReadWrite;

    //初始化请求对象
    public void initRequest(IReadWrite<T> obj) {
        this.iReadWrite = obj;
    }

    //读取数据
    public T requestData() {
        if (iReadWrite == null) {
            throw new RuntimeException("请初始化对象");
        }
        return iReadWrite.read();
    }

    //写入数据
    public boolean writeData(T data) {
        return iReadWrite.write(data);
    }


    public final static int TYPE_DISK = 1; //文件操作
    public final static int TYPE_NET = 2; //网络操作
    public final static int TYPE_DB = 3;//数据库操作
}
