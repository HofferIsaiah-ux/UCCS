# Vectors 
  # Use stringAsFactors = False, stops character vectors changing to factors


# Types 
  # Atomic Vectors 
    # All Elements Must Be Same Type 
````#Always Flat, even if nested vectors 
      # c(1, c(2, c(3, c(4)))) -> {1,2,3,4} <- c(1, 2, 3 ,4)
    #Syntax 
      # dbl_var <- c(1, 2.5, 4)
      # int_var <- c(1L, 6L, 10L) - Use L to get Integer instead of double 
      # log_var <- c(TRUE, False, T, F) - True = T and FALSE = F
      # chr_var <- c("String","String2")
  # Lists 
    # Element Type Can Differ 
    # Use list() not c()
    # Can be nested 
    #
# Functions
  # c() - only for Atomic 
  # list() - Only for lists
  # typeof() - Shows what type of vector
  # length() - give amount of elements 
  # attributes() - additional arbitrary metadata
  # is.vector() - true or false, true if vector has no attributes other than names(not a true vector test)
  # is.atomic() or is.list() - test if variable is a vector or not
  # is.integer() - True or False
  # is.double() - True of False
  # is.numberic() - True or False
  # as.numeric() - Turns non-numbers into numbers (True = 1)
  # as.character() 
  # as.double() 
  # as.integer() 
  # as.logical() 
  # is.recursive() - For lists, True or False 
  # is.list() - True or False
  # as.list() 
  # un.list()
  # attr(variableName, "attributeName") - Create Attribute 
  # structure( VECTOR , attricuteName = VALUE)

# Attributes 
  #Only 3 are not lost when updating vector 
    # 1. Names, a character vector giving each element a name.
      # names()
      # setnames()
    # 2. Dimensions, used to turn vectors into matrices and arrays.
      # dim()
    # 3. Class, used to implement the S3 object system.
      # class()

#Factor 
  #Only allows specific values 
  # Cannot combine factors - c(factor1, factor 2)


#Functions
  # factor() - creates a factor from vector 
  # class() - returns class (factor)
  # levels() - returns accepted values, factor( VECTOR, levels = c(VARIABLE1,...))
  # table() - returns levels and amount of each 
  # 

# Data Frames
  # Stores Data 
  # Data Frame has 2 equal size list, 2D list 
  # Can be used as a 1D list or 2D matrix 
  # Use stringAsFactors = False, stop string Data Frames changing to factors 
  # 
#Functions
  # names() 
  # ncol() & nrow() - find number of coulums and rows 
  # data.frame() - create data frame 
  # is.data.frame() - True or False 
  # as.data.frame() 
  # cbind() & rbind() - combine data frames 
  # I() - treat list as one unit, data.frame(x = 1:3, y = I(list(1:2, 1:3, 1:4))) (will not error)
  # x



