using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WebApplication1.DataAccess.Interface;
using WebApplication1.DataAccess.Model;
using WebApplication1.Transport;

namespace WebApplication1.Service
{
    public class TimeSlotService : ITimeSlotService
    {
        private readonly ITimeSlotRepository timeSlotRepository;

        public TimeSlotService(ITimeSlotRepository timeSlotRepository)
        {
            this.timeSlotRepository = timeSlotRepository;
        }

        /// <summary>
        /// Méthode principale d'update
        /// </summary>
        /// <returns></returns>
        public bool UpsertTimeSlot(TimeSlotDto timeSlotDto)
        {
            // Vérification Server-Side
            if (CheckDto(timeSlotDto))
            {
                try
                {
                    // Récupération des TimeSlots de l'utilisateur pour la date en base
                    var timeslots = timeSlotRepository.GetByUserId(timeSlotDto.UserId).Where(x => x.ReferredDate.Date == timeSlotDto.Date.Date);
                    // Si on en trouve
                    if (timeslots.Any())
                    {
                        // On les supprime
                        timeSlotRepository.DeleteTimeSlots(timeslots);
                    }
                    // Conversion DTO -> Entity
                    timeslots = CreateTimeSlots(timeSlotDto);
                    // Ajout en base
                    this.timeSlotRepository.AddRange(timeslots);
                }
                catch
                {
                    return false;
                }

            }
            else
            {
                return false;
            }
            return true;
        }

        /// <summary>
        /// Récupération d'une journée de time slot pour un user
        /// </summary>
        /// <param name="date">Date</param>
        /// <param name="userId">Id user</param>
        /// <returns>Objet Dto avec les slot d'une journée pour un user</returns>
        public TimeSlotDto GetSlotsByDateAndUser(DateTime date, int userId)
        {
            var slots = timeSlotRepository.GetByUserId(userId).Where(x => x.ReferredDate.Date == date.Date);
            Dictionary<int, int> countByProject = new Dictionary<int, int>();
            if (slots.Any())
            {
                foreach (var slot in slots)
                {
                    countByProject.Add(slot.IdProject, slot.HourCount);
                }
            }
            return new TimeSlotDto() { Date = date.Date, UserId = userId, TimeByProject = countByProject };
        }


        /// <summary>
        /// Création des entités à partir du dto
        /// </summary>
        /// <param name="timeSlotDto">Dto</param>
        /// <returns>Liste d'entité</returns>
        private IEnumerable<Timeslot> CreateTimeSlots(TimeSlotDto timeSlotDto)
        {
            var timeSlots = new List<Timeslot>();
            foreach (var slot in timeSlotDto.TimeByProject)
            {
                timeSlots.Add(new Timeslot()
                {
                    IdUser = timeSlotDto.UserId,
                    IdProject = slot.Key,
                    HourCount = slot.Value,
                    ReferredDate = timeSlotDto.Date.Date
                });
            }
            return timeSlots;
        }

        /// <summary>
        /// Vérif de l'intégrité des données
        /// </summary>
        /// <param name="timeSlotDto"></param>
        /// <returns></returns>
        private bool CheckDto(TimeSlotDto timeSlotDto)
        {
            var count = 0;
            foreach (var pair in timeSlotDto.TimeByProject)
            {
                count += pair.Value;
            }
            // Vérification : La somme des heures doit-être égale à 8
            if (count == 8)
            {
                // Vérification : La date du jour ne doit pas être du week-end
                if (timeSlotDto.Date.Date.DayOfWeek == DayOfWeek.Sunday || timeSlotDto.Date.Date.DayOfWeek == DayOfWeek.Saturday)
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
            return true;
        }
    }
}
