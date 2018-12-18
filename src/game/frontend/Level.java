package game.frontend;

import game.backend.level.Level1;
import game.backend.level.Level2;
import game.backend.level.Level3;

public enum Level {

    LEVEL1(Level1.class),
    LEVEL2(Level2.class),
    LEVEL3(Level3.class);

    private Class<?> clazz;

    Level(Class<?> clazz){
        this.clazz = clazz;
    }

    public Class<?> getClazz(){
        return clazz;
    }

}
