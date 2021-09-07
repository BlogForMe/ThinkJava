package pattern.strategy;


import static org.junit.Assert.assertEquals;
import static pattern.strategy.DataUtil.TYPE_DB;
import static pattern.strategy.DataUtil.TYPE_DISK;
import static pattern.strategy.DataUtil.TYPE_NET;

public class Test {

    public static void main(String[] args) {
        DataUtil<String> INSTANCE = DataUtil.getInstance();
        INSTANCE.initRequest(DataFactor.CreateObj(TYPE_DB));
        String data = INSTANCE.requestData();

        System.out.println(data);

    }

    @org.junit.Test
    void test(){
        DataUtil<String> INSTANCE = DataUtil.getInstance();
        INSTANCE.initRequest(DataFactor.CreateObj(TYPE_NET));
        assertEquals("从网络读取数据",INSTANCE.requestData());

        INSTANCE.initRequest(DataFactor.CreateObj(TYPE_DISK));
        assertEquals("从磁盘读取数据",INSTANCE.requestData());

        INSTANCE.initRequest(DataFactor.CreateObj(TYPE_DB));
        assertEquals("从数据库读取数据", INSTANCE.requestData());

    }

}
