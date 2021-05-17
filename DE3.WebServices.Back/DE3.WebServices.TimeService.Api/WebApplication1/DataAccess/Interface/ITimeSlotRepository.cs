using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WebApplication1.DataAccess.Model;

namespace WebApplication1.DataAccess.Interface
{
    public interface ITimeSlotRepository
    {
        webservicedbContext dbContext { get; }

        Timeslot Add(Timeslot timeslot);
        IEnumerable<Timeslot> GetByDate(DateTime date);
        Timeslot GetById(int id);
        IEnumerable<Timeslot> GetByUserId(int userId);
        void DeleteTimeSlots(IEnumerable<Timeslot> timeslot);
        void AddRange(IEnumerable<Timeslot> timeslots);
    }
}
