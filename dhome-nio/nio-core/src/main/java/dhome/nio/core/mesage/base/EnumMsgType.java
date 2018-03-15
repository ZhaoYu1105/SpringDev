package dhome.nio.core.mesage.base;

public enum EnumMsgType {
    EnumMsgPing("ping"), EnumMsgPong("pong");

    private String value;

    private EnumMsgType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
