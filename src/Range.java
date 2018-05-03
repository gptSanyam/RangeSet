class Range {
    int start;
    int end;

    Range(int start, int end){
        if(end>=start) {
            this.start = start;
            this.end = end;
        }
    }

    Range(Range existingRange){
        //todo use a clone method instead
        this(existingRange.start, existingRange.end);
    }

    CONTAINMENT_STATUS getContainmentStatus(Range rn){//todo clean up the below mess if possible
        if(rn.start > this.end || this.start>rn.end){
            return CONTAINMENT_STATUS.NO_OVERLAP;
        }
        if(rn.start<start && rn.end > start && rn.end <=end){
            return CONTAINMENT_STATUS.LEFT_OVERLAP;
        }
        if(rn.start>=start && rn.end > end && rn.start <end){
            return CONTAINMENT_STATUS.RIGHT_OVERLAP;
        }
        if(rn.start>=start && rn.start<end && rn.end>start && rn.end<=end){
            return CONTAINMENT_STATUS.CONTAINS;
        }
        if(rn.start<start && rn.end>end){
            return CONTAINMENT_STATUS.CONTAINED;
        }
        return CONTAINMENT_STATUS.NO_OVERLAP;
    }

    int getSize(){
        return end - start + 1;
    }

    boolean contains(int num){
        return num>=start && num<=end;
    }

    int getSum(){ //will act as the parameter to comparator
        int sum = 0;
        for(int i = start; i<=end; i++){
            sum += i;
        }
        return sum;
    }

    Range cloneRange(){
        return new Range(this);
    }

}

