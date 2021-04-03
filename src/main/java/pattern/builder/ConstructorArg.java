package pattern.builder;

public class ConstructorArg {
    private boolean isRef;
    private Class type;
    private Object arg;

    private ConstructorArg(Builder builder) {
        this.isRef = isRef;
        this.type = type;
        this.arg = arg;
    }

    public static class Builder {
        private static boolean isRef;
        private static Class type;
        private static Object arg;

        public Builder(boolean isRef) {
            this.isRef = isRef;
        }

        public Builder setType(Class type) {
            this.type = type;
            return this;
        }

        public Builder setArg(Object arg) {
            this.arg = arg;
            return this;
        }

        public ConstructorArg build() {
            if (isRef) {
                if (!(arg instanceof String)) {
                    //这里refBeanId是ConstructorArg吗？只是判断了下arg类型是否为String
                    throw new IllegalArgumentException("当 isRef 为 true 的时候，arg 表示 String 类型refBeanId");
                }
                if (type != null) {
                    throw new IllegalArgumentException("当 isRef 为 true 的时候，type 不需要设置");
                }
            }
            if (!isRef) {
                if (arg == null || type == null) {
                    throw new IllegalArgumentException("当 isRef 为 false 的时候，arg、type 都需要设置");
                }
            }
            return new ConstructorArg(this);
        }
    }
}
