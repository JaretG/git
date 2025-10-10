/*
You've begun your new job to organize newspapers. Each morning, you are to separate the newspapers into smaller piles and assign each pile to a co-worker. This way, your co-workers can read through the newspapers and examine their contents simultaneously.

Each newspaper is marked with a read time to finish all its contents. A worker can read one newspaper at a time, and, when they finish one, they can start reading the next. Your goal is to minimize the amount of time needed for your co-workers to finish all newspapers. Additionally, the newspapers came in a particular order, and you must not disarrange the original ordering when distributing the newspapers. In other words, you cannot pick and choose newspapers randomly from the whole pile to assign to a co-worker, but rather you must take a subsection of consecutive newspapers from the whole pile.

What is the minimum amount of time it would take to have your coworkers go through all the newspapers? That is, if you optimize the distribution of newspapers, what is the longest reading time among all piles?

Constraints
1 <= newspapers_read_times.length <= 10^5

1 <= newspapers_read_times[i] <= 10^5

1 <= num_coworkers <= 10^5
*/ 
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Collections;

class NewspaperSplit {
    public static int newspapersSplit(List<Integer> newspapersReadTimes, int numCoworkers) {
        int low=Collections.max(newspapersReadTimes);//least readtime by 1(biggest book once)
        int high=0;//all if read by one
        int res=-1;//this will be tested
        for(int readTime:newspapersReadTimes){
            high+=readTime;
        }
        while(low<=high){
            int mid=(high+low)/2;
            if(possible(newspapersReadTimes,mid,numCoworkers)){
                res=mid;
                high=mid-1;
                
            }else{
                low=mid+1;
            }
        }
        return res;
    }

    public static boolean possible(List<Integer> list,int target,int numCoworkers){
        int timeCounter=0,workerCounter=0;
        for(int num : list){
            if(timeCounter+num>target){
                timeCounter=0;//reset
                workerCounter++;
            }//this means we need another worker since it won't be finished by current worker
            timeCounter+=num;
        }
        if(timeCounter!=0){
            workerCounter++;
        }
        return workerCounter<=numCoworkers;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type list of newspaper read times seperated by a space");
        List<Integer> newspapersReadTimes = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("Type list of newspaper read times seperated by a space");

        int numCoworkers = Integer.parseInt(scanner.nextLine());
        System.out.println("How may workers are the newspapers going to be seperated by");

        scanner.close();
        int res = newspapersSplit(newspapersReadTimes, numCoworkers);
        System.out.println("It will take atleast "+res+" hours");
    }
}