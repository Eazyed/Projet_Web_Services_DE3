using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WebApplication1.Service;
using WebApplication1.Transport;

namespace WebApplication1.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class TimeController : ControllerBase
    {
        private readonly ILogger<TimeController> _logger;
        private readonly ITimeSlotService timeSlotService;

        public TimeController(ILogger<TimeController> logger, ITimeSlotService timeSlotService)
        {
            _logger = logger;
            this.timeSlotService = timeSlotService;
        }

        [HttpGet]
        public IActionResult Get(DateTime date, int userId)
        {
            return new OkObjectResult(this.timeSlotService.GetSlotsByDateAndUser(date.Date, userId));
        }

        [HttpPost]
        public IActionResult UpsertSlots([FromBody] TimeSlotDto dto)
        {
            if (this.timeSlotService.UpsertTimeSlot(dto))
            {
                return Ok();
            }
            else
            {
                return BadRequest();
            }            
        }
    }
}
