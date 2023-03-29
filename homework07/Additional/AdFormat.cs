class AdFormat
{
       public static string lenForm(string str, int n)
    {
        int k=str.Length+1;
        if (str.Length >= n) return str;
        else
        {
            
            for (int i = 0; i < (n - str.Length+1); i++)
            {   
                //k=k+i;
                str = str + " ";
            }
        return str;
        }
    } 
}