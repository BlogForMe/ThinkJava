package pattern.strategy;

import static pattern.strategy.DataUtil.*;

/**
 * 生成对象
 */
public class DataFactor {
    public static IReadWrite CreateObj(int type) {

        if (type == TYPE_DISK) {
            return new DiskReadWrite();
        } else if (type == TYPE_DB) {
            return new DbReadWrite();
        } else if (type == TYPE_NET) {
            return new NetworkRead();
        } else {
            throw new RuntimeException("对象创建失败");
        }
    }
}
