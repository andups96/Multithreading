package executors_callables.merge_sort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {

    private List<Integer> arrayToSort;
    private ExecutorService executorService;

    public MergeSorter(List<Integer> arrayToSort, ExecutorService executorService) {
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if (arrayToSort.size() <= 1) {
            return arrayToSort;
        }
        int mid = arrayToSort.size() / 2;
        List<Integer> leftArray = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            leftArray.add(arrayToSort.get(i));
        }
        List<Integer> rightArray = new ArrayList<>();
        for (int i = mid; i < arrayToSort.size(); i++) {
            rightArray.add(arrayToSort.get(i));
        }

        MergeSorter leftMergeSorter = new MergeSorter(leftArray, executorService);
        MergeSorter rightMergeSorter = new MergeSorter(rightArray, executorService);

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<List<Integer>> leftSortedArrayFuture = executorService.submit(leftMergeSorter);
        Future<List<Integer>> rightSortedArrayFuture = executorService.submit(rightMergeSorter);
        List<Integer> leftSortedArray = leftSortedArrayFuture.get();
        List<Integer> rightSortedArray = rightSortedArrayFuture.get();

        //Merge the two sorted arrays
        int i = 0, j = 0;
        List<Integer> mergedSortedArray = new ArrayList<>();
        while (i < leftSortedArray.size() && j < rightSortedArray.size()) {
            if (leftSortedArray.get(i) < rightSortedArray.get(j)) {
                mergedSortedArray.add(leftSortedArray.get(i));
                i++;
            } else {
                mergedSortedArray.add(rightSortedArray.get(j));
                j++;
            }
        }
        while (i < leftSortedArray.size()) {
            mergedSortedArray.add(leftSortedArray.get(i));
            i++;
        }
        while (j < rightSortedArray.size()) {
            mergedSortedArray.add(rightSortedArray.get(j));
            j++;
        }

        return mergedSortedArray;
    }
}