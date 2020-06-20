package misat11.lib.lang;

public class MessageReceiver {
    private final Object original;
    private final String name;

    public MessageReceiver(Object object, String name) {
        this.original = object;
        this.name = name;
    }

    public Object getPlatformSender() {
        return original;
    }

    public <T> T getPlatformSender(Class<T> type) {
        return type.cast(original);
    }

    public String getName() {
        return name;
    }
}
