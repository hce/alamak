package li.hce.alamak;

public final class Maybe<T> {
    private final T inner;

    private Maybe(final T inner) {
        this.inner = inner;
    }

    public static <T>Maybe<T> just(final T what) {
        if (what == null) {
            throw new NullPointerException("Liddis cannot hor");
        }
        return new Maybe<>(what);
    }

    public static <T>Maybe<T> nothing() {
        return new Maybe<>(null);
    }

    public boolean isJust() {
        return inner != null;
    }

    public boolean isNothing() {
        return inner == null;
    }

    public T asJust() {
        if (inner == null) {
            throw new NullPointerException("Liddat also cannot");
        }
        return inner;
    }
}
