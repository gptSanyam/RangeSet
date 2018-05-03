import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class RangeSet{ //overlapping ranges will be merged
    List<Range> container; //todo change this to sorted set

    RangeSet(){
        container = new ArrayList<>();
    }

    RangeSet(RangeSet existingSet){
        //todo
    }

    RangeSet(int start, int end){
        Range range = new Range(start, end);
    }

    RangeSet(Range range){
        this();
        this.addRange(range);
    }

    int addRange(int start, int end){
        Range range = new Range(start, end);
        addRange(range);
        return getSize();
    }

    int addRange(Range rn){
        container.add(rn);
        //todo merge the new range with existing ranges, not needed for existing problem
        return getSize();
    }

    int removeRange(int start, int end){
        Range range = new Range(start, end);
        removeRange(range);
        return getSize();
    }

    int removeRange(Range rn){
        Iterator<Range> itr = container.iterator();
        RangeSet tmpRangeSet  = new RangeSet();
        while(itr.hasNext()){
            Range r = itr.next();
            //todo RangeSet rSet = diffSets(r, rn, tmpRangeSet);
        }
        return getSize();
    }

    void diffSets(Range r1, Range r2, RangeSet rSet){ //r1-r2

        CONTAINMENT_STATUS status = r1.getContainmentStatus(r2);

        switch(status){
            case CONTAINED:
                break;
        }

    }

    int getSize(){
        int size = 0;
        for (Range r: container) {
            size+=r.getSize();
        }
        return size;
    }

}

