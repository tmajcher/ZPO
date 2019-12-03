import java.util.ArrayList;
import java.util.List;

public class MaxSearchAlgorithms {

    public List<Integer> scanLeftToRight(List<Integer> list){
        List<Integer> temp = new ArrayList<>();
        temp.add(list.get(0));
        for (int i = 1; i < list.size() ; i++) {
            if(list.get(i) > temp.get(temp.size()-1))
                temp.add(list.get(i));
        }

        return temp;
    }

    public List<Integer> scanRightToLeft(List<Integer> list){
        List<Integer> temp = new ArrayList<>();
        temp.add(list.get(list.size()-1));
        for (int i = list.size() - 1; i >= 0 ; i--) {
            if(list.get(i) > temp.get(temp.size()-1))
                temp.add(list.get(i));
        }

        return temp;
    }

    public List<Integer> scanLast(List<Integer> list){
        List<Integer> temp = new ArrayList<>();
        temp.add(list.get(0));
        if(list.size() >= 2) {
            for (int i = 2; i < list.size(); i += 2) {
                if (list.get(i) > temp.get(temp.size() - 1))
                    temp.add(list.get(i));
            }
        }
        for (int i = 1; i < list.size() ; i+=2) {
            if (list.get(i) > temp.get(temp.size() - 1))
                temp.add(list.get(i));
        }

        return temp;
    }

}
