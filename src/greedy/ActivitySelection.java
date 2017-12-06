package greedy;

import java.util.*;

public class ActivitySelection {
    public static void main(String args[]){
        List<Activity> activities = new ArrayList<>();
        Random random = new Random(System.currentTimeMillis());
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<20;i++){
            String num = scanner.nextLine();
            String[] temp = num.split(",");
            //int start = random.nextInt(10);
            int start = Integer.parseInt(temp[0].split("\\{")[1]);
            //int end = start+random.nextInt(10);
            int end = start+Integer.parseInt(temp[1].split("}")[0]);
            if(start==end) end++;
            activities.add(new Activity(start,end));
            System.out.println(activities.get(i));
        }
        int n = 6;
        int count = findMaxActivities(activities, n);
        System.out.println(count);
    }

    private static int findMaxActivities(List<Activity> activities, int n) {
        activities.sort((a1,a2)->a1.end==a2.end?a1.start-a2.start:a1.end-a2.end);
        System.out.println(activities);
        int count = 1,lastEnd = activities.get(0).end;
        for(int i=1;i<activities.size();i++){
            if(activities.get(i).start>=lastEnd) {
                lastEnd = activities.get(i).end;
                count++;
            }
        }
        return count;
    }
}
class Activity{
    int start;
    int end;

    Activity(int i, int i1) {
        start = i;
        end = i1;
    }

    @Override
    public String toString() {
        return "{"+start+","+end+"}";
    }
}