package pattern.chain;

public abstract class Manager {
    protected String name;
    protected Manager superior;//管理者上级

    public Manager(String name) {
        this.name = name;
    }

    // 设置管理者上级
    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    //申请请求
    abstract void requestApplications(Request request);
}
