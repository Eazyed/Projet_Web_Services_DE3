using System;
using WebApplication1.Transport;

namespace WebApplication1.Service
{
    public interface ITimeSlotService
    {
        /// <summary>
        /// Récupération d'une journée de time slot pour un user
        /// </summary>
        /// <param name="date">Date</param>
        /// <param name="userId">Id user</param>
        /// <returns>Objet Dto avec les slot d'une journée pour un user</returns>
        TimeSlotDto GetSlotsByDateAndUser(DateTime date, int userId);
        bool UpsertTimeSlot(TimeSlotDto timeSlotDto);
    }
}