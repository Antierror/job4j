package ru.job4j.tracker;

/**
 * @author Konstantin Kazakov (plan.05.87@gmail.com).
 * @version $Id$
 * @since 0.1
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private long create;
    private String[] comments;


    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getName() {
        return this.name;
    }

    public void  setName() {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void  setDescription() {
        this.description = description;
    }

    public long getCreate() {
        return this.create;
    }

    public void  setCreate() {
        this.create = create;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getComments() {
        return this.comments;
    }

    public void  setComments() {
        this.comments = comments;
    }
}
