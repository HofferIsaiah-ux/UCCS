
#library(dplyr) - Need This

# select(DATANAME, VARIABLES1, VARIABLE2...,) - add tables/groups to dataset
# view(DATANAME) -- shows what in dataset 
# filter(DATANAME,VARIABLE1 = SOMETHING,...) - Can use | or & to further filter data, can also take arrays
# mutate(DATANAME,STATEMENT) - Filter Data Using A True Or False Statement 
    # VARIABLE = ifelse(VARIABLE > #,ADDTHISIFTRUE,ADDTHISIFFALSE)
    #          = ifelse(VARIABLE %in% c(COLOR1,COLOR2,...),ADDTHISIFTRUE,ADDTHISIFFALSE)
# summerize(DATANAME, TABLENAME1 = mean(VARIABLE1, na.rm = True),TABLENAME2(...))
  # na.rm = Will Not Display Cells With NA

# Operators
# <,>
# |, &
# %in% - in member of 
# %>% - Passes Result On Left To First Parameter Of the Function On The Right 
# $ Get Specific "name" in data frame 
