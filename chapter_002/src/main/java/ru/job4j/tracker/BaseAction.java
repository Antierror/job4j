package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {
    private final int key;
    private final String actoin;

    protected BaseAction(final int key, final String action) {
        this.key = key;
        this.actoin = action;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s : %s", this.key, this.actoin);
    }
}
