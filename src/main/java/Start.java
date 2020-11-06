import lombok.extern.log4j.Log4j;
import ru.infernia.entity.GameObject;
import stub.GeneratorStub;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author Vostryakov Alexander
 */
@Log4j
public class Start {
    private List<GameObject> visibleObjects;

    public Start() {

//        beginSession();
        visibleObjects = GeneratorStub.createAnimateStub();

        visibleObjects = visibleObjects.stream()
                .sorted(Comparator.comparingInt(GameObject::getLayer))
                .collect(Collectors.toList());



    }

    public static void main(String[] args) {
        new Start();
    }


}
