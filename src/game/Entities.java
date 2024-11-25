package game;

import java.util.ArrayList;
import java.util.List;

public class Entities
{
    public static final List<Entity> SET_ENTITIES = new ArrayList<>();

    public static final Entity PIG = register("pig", MobType.ANIMAL);
    public static final Entity Fire_Dragon = register("dragon_fire", MobType.BOSS);
    public static final Entity skeleton = register("skeleton", MobType.MONSTER);

    public static Entity register(String name, MobType mT)
    {
        Entity e = new Entity(name, mT);
        SET_ENTITIES.add(e);
        return e;
    }

    public static void main(String[] args)
    {
        for(int i = 0; i < Entities.SET_ENTITIES.size(); i++)
        {
            System.out.println("REGISTRY ENTITY ENTRY : " + Entities.SET_ENTITIES.get(i).getName() +
                    " is a "+ Entities.SET_ENTITIES.get(i).getType().toString() +" Mob Type");
        }
    }
}
