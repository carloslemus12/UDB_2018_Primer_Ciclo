﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using System;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;

public partial class db_roaming_guatemalaEntities : DbContext
{
    public db_roaming_guatemalaEntities()
        : base("name=db_roaming_guatemalaEntities")
    {
    }

    protected override void OnModelCreating(DbModelBuilder modelBuilder)
    {
        throw new UnintentionalCodeFirstException();
    }

    public virtual DbSet<cliente> cliente { get; set; }
    public virtual DbSet<facturacion> facturacion { get; set; }
    public virtual DbSet<tipo_clientes> tipo_clientes { get; set; }
}
