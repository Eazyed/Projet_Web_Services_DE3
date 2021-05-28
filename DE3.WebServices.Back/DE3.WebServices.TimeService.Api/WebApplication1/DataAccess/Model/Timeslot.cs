using System;
using System.Collections.Generic;

#nullable disable

namespace WebApplication1.DataAccess.Model
{
    public partial class Timeslot
    {
        public int IdSlot { get; set; }
        public int HourCount { get; set; }
        public int IdUser { get; set; }
        public int IdProject { get; set; }
        public DateTime ReferredDate { get; set; }
    }
}
