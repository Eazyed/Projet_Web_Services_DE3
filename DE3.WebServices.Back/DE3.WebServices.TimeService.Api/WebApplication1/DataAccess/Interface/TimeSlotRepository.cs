using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WebApplication1.DataAccess.Model;

namespace WebApplication1.DataAccess.Interface
{
    public class TimeSlotRepository : ITimeSlotRepository
    {
        public webservicedbContext dbContext { get; }

        public TimeSlotRepository(webservicedbContext context)
        {
            this.dbContext = context;
        }

        public Timeslot GetById(int id)
        {
            return this.dbContext.Set<Timeslot>().FirstOrDefault(x => x.IdSlot == id);
        }

        public Timeslot Add(Timeslot timeslot)
        {
            var obj = this.dbContext.Set<Timeslot>().Add(timeslot);
            this.dbContext.SaveChanges();
            return obj.Entity;
        }

        public IEnumerable<Timeslot> GetByUserId(int userId)
        {
            var a =  this.dbContext.Set<Timeslot>().Where(x => x.IdUser == userId).ToList();
            return this.dbContext.Set<Timeslot>().Where(x => x.IdUser == userId);
        }

        public IEnumerable<Timeslot> GetByDate(DateTime date)
        {
            return this.dbContext.Set<Timeslot>().Where(x => x.ReferredDate == date);
        }

        public void DeleteTimeSlots(IEnumerable<Timeslot>timeslot)
        {
            this.dbContext.Set<Timeslot>().RemoveRange(timeslot);
            this.dbContext.SaveChanges();
        }

        public void AddRange(IEnumerable<Timeslot> timeslots)
        {
            this.dbContext.Set<Timeslot>().AddRange(timeslots);
            this.dbContext.SaveChanges();
        }
    }
}
