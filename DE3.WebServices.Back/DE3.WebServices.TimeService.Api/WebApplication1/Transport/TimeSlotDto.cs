using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebApplication1.Transport
{
    public class TimeSlotDto
    {
        /// <summary>
        /// Date du jour
        /// </summary>
        public DateTime Date { get; set; }

        /// <summary>
        /// Id de l'utilisateur
        /// </summary>
        public int UserId { get; set; }

        /// <summary>
        /// Différents créneaux
        /// </summary>
        public Dictionary<int,int> TimeByProject { get; set; }
    }
}
