package agrendalath.rock_paper_scissors;

import java.util.*;

class RPS {
    private final Map<FigureInterface, Set<? extends FigureInterface>> relations = new HashMap<>();

    RPS() {
        initialize();
    }

    FigureInterface getFigure(String name) {
        return FigureInterface.getEnum(name, Figures.class);
    }

    FigureInterface[] getAllFigures() {
        return FigureInterface.getAllEnums(Figures.class);
    }

    void addRelation(FigureInterface figure, Set<? extends FigureInterface> set) {
        relations.put(figure, set);
    }

    private void initialize() {
        addRelation(
                getFigure("Rock"),
                new HashSet<>(Collections.singletonList(getFigure("Scissors")))
        );
        addRelation(
                getFigure("Paper"),
                new HashSet<>(Collections.singletonList(getFigure("Rock")))
        );
        addRelation(
                getFigure("Scissors"),
                new HashSet<>(Collections.singletonList(getFigure("Paper")))
        );
    }

    /**
     * @param first  The first figure.
     * @param second The second figure.
     * @return Returns 0 in case of draw (figures are the same).
     * Returns 1 if the first figure beats the second one.
     * Returns -1 if the second figure beats the first one.
     */
    int fight(FigureInterface first, FigureInterface second) {
        if (first == second)
            return 0;
        return relations.get(first).contains(second) ? 1 : -1;
    }
}
