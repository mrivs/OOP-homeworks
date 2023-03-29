using System.Text.RegularExpressions;

public class Names
{
    private static string names = @"Abraham, Addison, Adrian, Albert, Alec, Alfred, Alvin, Andrew, Andy, Archibald, Archie, Arlo, Arthur,
    Austen, Barnabe, Bartholomew, Bertram, Bramwell, Byam, Cardew, Chad, Chance, Colin, Coloman, Curtis, 
    Cuthbert, Daniel, Darryl, David, Dickon, Donald, Dougie, Douglas, Earl, Ebenezer, Edgar, Edmund, Edward, Edwin, Elliot, Emil, Floyd, Franklin, Frederick,
    Gabriel, Galton, Gareth, George, Gerard, Gilbert, Gorden, Gordon, Graham, Grant, Henry, Hervey, Hudson, Hugh, Ian, Jack, Jaime, James, Jason, Jeffrey, John, Jolyon, Jonas,
    Joseph, Joshua, Julian, Justin, Kurt, Lanny, Larry, Laurence, Lawton, Lester, Malcolm, Marcus,
    Mark, Marshall, Martin, Marvin, Matt, Maximilian, Michael, Miles, Murray, Myron, Nate, Nathan,
    Neil, Nicholas, Nicolas, Norman, Oliver, Oscar, Osric, Owen, Patrick, Paul, Peleg, Philip, Phillipps,
    Raymond, Reginald, Rhys, Richard, Robert, Roderick, Rodger, Roger, Ronald, Rowland, Rufus, Russell";
        
    
    //private static int len = words.Length;
    private static Random rnd = new Random();
    private static string str = Regex.Replace(names, @"[ \r\n\t]", "");
    private static string[] words = str.Split(",");
    private static int len = words.Length;

    public static string getRandName()
    {   

        return words[rnd.Next(0, len - 1)];
    }
}
