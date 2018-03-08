using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{
    private static Random random = new Random();

    public static string RandomString(int length)
    {
        const string chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        return new string(Enumerable.Repeat(chars, length).Select(s => s[random.Next(s.Length)]).ToArray());
    }

    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void tmusuario_Tick(object sender, EventArgs e)
    {
        this.sqlUsuarios.InsertParameters["Codigo"].DefaultValue = RandomString(4);
        this.sqlUsuarios.InsertParameters["NombreUsuario"].DefaultValue = RandomString(7);
        this.sqlUsuarios.InsertParameters["ClaveUsuario"].DefaultValue = RandomString(6);
        this.sqlUsuarios.InsertParameters["Coreo"].DefaultValue = RandomString(10) +"@" + RandomString(5) + ".com";
        this.sqlUsuarios.InsertParameters["TipoUsuario"].DefaultValue = random.Next(1, 6).ToString();
        this.sqlUsuarios.InsertParameters["Estado"].DefaultValue = "1";

        this.sqlUsuarios.Insert();
    }
}