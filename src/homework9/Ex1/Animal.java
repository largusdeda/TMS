package homework9.Ex1;

/**
 * @author Elena Chinarina
 *
 **/

public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void voice();
    public abstract void eat(String food);

    public String getName() {
        return name;
    }
}
