CREATE TABLE [dbo].[Person] (
    [id]               [bigint] IDENTITY(1,1)   NOT NULL,
    [firstName]        [nvarchar](100)          NOT NULL,
    [lastName]         [nvarchar](100)          NOT NULL,
    [createdDateUtc]   [datetime]               NOT NULL,
 CONSTRAINT [PK_Id] PRIMARY KEY CLUSTERED (
    [id] ASC
  ),
 CONSTRAINT [UC_Thermostat_Name] UNIQUE NONCLUSTERED (
    [firstName] ASC,
    [lastName] ASC
  )
)
GO