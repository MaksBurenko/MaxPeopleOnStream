import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountStreamers {

        public static int count(int[][] times) {
            List<EventItem> events = new ArrayList<>();
            for (int[] time:
                    times) {
                events.add(new EventItem(time[0], EventType.START));
                events.add(new EventItem(time[1], EventType.STOP));
            }

            Collections.sort(events, Comparator.comparingInt(value -> value.time));

            int current = 0;
            int max = 0;

            for (EventItem event:
                    events) {
                current += (event.eventType == EventType.START) ? +1 : -1;
                if (current > max) {
                    max = current;
                }
            }
            return max;
        }

        public enum EventType {
            START, STOP
        }

        public static class EventItem {
            int time;
            EventType eventType;

            public EventItem(int time, EventType eventType) {
                this.time = time;
                this.eventType = eventType;
            }
        }
    }
