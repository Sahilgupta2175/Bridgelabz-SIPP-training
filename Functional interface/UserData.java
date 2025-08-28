public class UserData implements BackupSerializable, SensitiveData, Cloneable {
    private String name;
    private String password;

    public UserData(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
