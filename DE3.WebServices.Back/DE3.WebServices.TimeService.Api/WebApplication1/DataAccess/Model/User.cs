using System;
using System.Collections.Generic;

#nullable disable

namespace WebApplication1.DataAccess.Model
{
    public partial class User
    {
        public int IdUser { get; set; }
        public string Firstname { get; set; }
        public string Lastname { get; set; }
        public string Username { get; set; }
        public string Password { get; set; }
        public string Salt { get; set; }
        public string Role { get; set; }
    }
}
