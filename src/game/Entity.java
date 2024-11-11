package game;

public class Entity
{
    private String name;
    private MobType type;
    private boolean fR = false;

    public Entity(String n, MobType t)
    {
        this.name=n;
        this.type=t;
    }

    public Entity setImmuneFire()
    {
        this.fR = true;
        return this;
    }

    public String getName() {
        return name;
    }

    public MobType getType() {
        return type;
    }
}