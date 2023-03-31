using System.Text.RegularExpressions;

class AdFormat
{
       public static string lenForm(string str, int n)
    {   str = Regex.Replace(str, @"[ \r\n\t]", "");
        int k=str.Length+1;
        if (str.Length >= n) return str;
        else
        {
            
            for (int i = 0; i < (n - k+1); i++)
            {   
                //k=k+i;
                str = str + " ";
            }
        return str;
        }
    } 
}