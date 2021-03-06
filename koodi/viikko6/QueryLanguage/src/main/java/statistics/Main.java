package statistics;

import java.util.List;
import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        
    /*Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
    
    QueryBuilder query = new QueryBuilder();
    Matcher m = (Matcher) query.build();

    for (Player player : stats.matches(m)) {
        System.out.println( player );
    }*/
        Matcher m;
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        System.out.println(" All " );
        //List<Player> players = stats.allPlayers();
        for (Player player : stats.allPlayers()) {
            System.out.println( player );
        }
        
        System.out.println(" And " );
        m = new And( new HasAtLeast(5, "goals"),
                             new HasAtLeast(10, "assists"),
                             new PlaysIn("PHI")
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("\n\n Not " );
        
        m = new Not( new HasAtLeast(1, "goals") );

        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }

        System.out.println("\n\n Or" );

        m = new Or( new HasAtLeast(40, "goals"),
                    new HasAtLeast(60, "assists"),
                    new HasAtLeast(85, "points")
        );   
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("\n\n HasFewerThan" );

        //m = new Not( new HasFewerThan(1, "goals"));
        m = (Matcher) new HasFewerThan(1, "goals");  
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        
    }
}
