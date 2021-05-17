using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

#nullable disable

namespace WebApplication1.DataAccess.Model
{
    public partial class webservicedbContext : DbContext
    {
        public webservicedbContext()
        {
        }

        public webservicedbContext(DbContextOptions<webservicedbContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Date> Dates { get; set; }
        public virtual DbSet<Project> Projects { get; set; }
        public virtual DbSet<Timeslot> Timeslots { get; set; }
        public virtual DbSet<User> Users { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see http://go.microsoft.com/fwlink/?LinkId=723263.
                optionsBuilder.UseMySQL("server=localhost;port=3306;user=root;password=;database=webservicedb");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Date>(entity =>
            {
                entity.HasKey(e => e.Date1)
                    .HasName("PRIMARY");

                entity.ToTable("dates");

                entity.Property(e => e.Date1)
                    .HasColumnType("date")
                    .HasColumnName("Date");

                entity.Property(e => e.MonthNum).HasColumnType("int(11)");

                entity.Property(e => e.WeekNum).HasColumnType("int(11)");
            });

            modelBuilder.Entity<Project>(entity =>
            {
                entity.HasKey(e => e.IdProject)
                    .HasName("PRIMARY");

                entity.ToTable("projects");

                entity.Property(e => e.IdProject).HasColumnType("int(11)");

                entity.Property(e => e.Label)
                    .IsRequired()
                    .HasMaxLength(50);
            });

            modelBuilder.Entity<Timeslot>(entity =>
            {
                entity.HasKey(e => e.IdSlot)
                    .HasName("PRIMARY");

                entity.ToTable("timeslots");

                entity.HasIndex(e => e.IdProject, "IdProject");

                entity.HasIndex(e => e.IdUser, "IdUser");

                entity.HasIndex(e => e.ReferredDate, "ReferredDate");

                entity.Property(e => e.IdSlot).HasColumnType("int(11)");

                entity.Property(e => e.HourCount).HasColumnType("int(11)");

                entity.Property(e => e.IdProject).HasColumnType("int(11)");

                entity.Property(e => e.IdUser).HasColumnType("int(11)");

                entity.Property(e => e.ReferredDate).HasColumnType("date");
            });

            modelBuilder.Entity<User>(entity =>
            {
                entity.HasKey(e => e.IdUser)
                    .HasName("PRIMARY");

                entity.ToTable("users");

                entity.Property(e => e.IdUser).HasColumnType("int(11)");

                entity.Property(e => e.Firstname)
                    .IsRequired()
                    .HasMaxLength(50);

                entity.Property(e => e.Lastname)
                    .IsRequired()
                    .HasMaxLength(50);

                entity.Property(e => e.Password)
                    .IsRequired()
                    .HasMaxLength(255);

                entity.Property(e => e.Role)
                    .IsRequired()
                    .HasColumnType("enum('manager','developer')");

                entity.Property(e => e.Salt)
                    .IsRequired()
                    .HasMaxLength(8)
                    .IsFixedLength(true);

                entity.Property(e => e.Username)
                    .IsRequired()
                    .HasMaxLength(50);
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
