                        # FINAL 

# QUESTION 1: Caffeine & Sleep Study 

#a. The appropriate test to use would be the paired t-test because 
# there are two vectors, and each person was tested twice. Meaning 
#the vectors create pairs (Caffeine, placebo)

#b. 
#Null Hypothesis: There is no difference in reaction time between caffeine and placebo. (mu_C = mu_P)

#Alternative Hypothesis: There is a difference in reaction time between caffeine and placebo ( mu_C != mu_P)

#c.
# Data Sets: 
Reaction_Caffeine <- c(260, 275, 249, 280, 271, 265, 289, 254, 260, 268, 276, 281, 263, 258,
                       274, 270, 255, 272, 267, 278)

Reaction_Placebo <- c(270, 280, 260, 290, 276, 270, 295, 258, 265, 270, 282, 286, 268, 260,
                      277, 275, 260, 275, 271, 283)


# Running T-test: 
t.test(Reaction_Caffeine, Reaction_Placebo, paired = TRUE) #Output: Paired t-test

                                                           #data:  Reaction_Caffeine and Reaction_Placebo
                                                           #t = -9.668, df = 19, p-value = 9.042e-09
                                                           #alternative hypothesis: true mean difference is not equal to 0
                                                           #95 percent confidence interval:
                                                             #-6.447402 -4.152598
                                                           #sample estimates:
                                                             #mean difference 
                                                           #-5.3 
#d. 
# Results: 
#P-Value: 9.042e-09
#Alpha: 0.05 
#95% Confidence Interval: -6.447402 -4.152598
#Mean Difference: -5.3 

# From the t-test we can conclude that the null hypothesis is invalid, meaning the reaction times between caffeine 
# and placebo are different. The mean difference between the two vectors is -5.3 meaning Reaction_Placebo was higerh 
#with an average difference of 5.3 for each par. 



# QUESTION 2: Three Teaching Methods

#a. The method to use would be One-way ANOVA because we have three independent groups 

#b. 
# Independence of observations 
# Normality within each group 
# Homogeneity of variances 

#c. 
Method <- factor(rep(c("A", "B", "C"), each = 6))
Score <- c(84, 80, 78, 82, 85, 79, 90, 87, 88, 91, 89, 85, 70, 74, 72, 76, 75, 73)

anova_Result = aov(Score ~ Method) 
summary(anova_Result) # Output:             Df  Sum Sq Mean Sq F value  Pr(>F)    
                              #Method       2    676   338.0   58.95  7.84e-08 ***
                              #Residuals   15     86     5.7                     
                              #---
                              #Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1

# Result: 
# P-Value: 7.84e-08 
# Alpha: 0.05

# CONCLUSION 
# Since P-Value < Alpha (7.84e-08 < 0.05), one group must differ greatly. 

#d.
# Find Group That Differs 
TukeyHSD(Anova_result) # Output: Tukey multiple comparisons of means
                                        #95% family-wise confidence level
                                        
                                        #Fit: aov(formula = Exam_scores ~ method, data = df)
                                        
                                        #$method
                                        #diff       lwr      upr     p adj
                                        #Method2-Method1 -9.0 -12.36052 -5.63948 0.0000324
                                        #Method3-Method1 -3.2  -6.56052  0.16052 0.0624803
                                        #Method3-Method2  5.8   2.43948  9.16052 0.0016216

# Using Tukey, we can see a big difference between method2 and method1, with method1 being bigger. 
# Method3 is still smaller than method1, but not as much as method2. Method2 is by far the worst method 
# and should no be repeated next year. Method1 is the best to continue, method3 can be continue for further data. 



#QUESTION 3: BONUS 
# Normality
shapiro.test(Score[Method == "A"]) # Output: hapiro-Wilk normality test

                                             #data:  Score[Method == "A"]
                                             #W = 0.94009, p-value = 0.6599

shapiro.test(Score[Method == "B"]) # Output: Shapiro-Wilk normality test

                                             #data:  Score[Method == "B"]
                                             #W = 0.98259, p-value = 0.9637

shapiro.test(Score[Method == "C"]) #Output: Shapiro-Wilk normality test

                                            #data:  Score[Method == "C"]
                                            #W = 0.98259, p-value = 0.9637

# Homogeneity of Variances
library(car)
leveneTest(Score ~ Method) # Output: Levene's Test for Homogeneity of Variance (center = median)
                                                  #Df F value Pr(>F)
                                            #group  2  0.6349 0.5436
                                              #15              

# CONCLUSTION: 
# All p-values are above 0.05 meaning are assumptions for normality and equal variance hold up. 
# The results from ANOVA are reliable  


# QUESTION 4: SHORT ANSWERS 

#a. Type 1 error is when you reject null hypothesis when it is actually true, 
#   and type 2 is when you do not reject null hypothesis when it is false. 
#   The worst error for medical research would be type 1 because it could lead to 
# harmful or ineffective treatment. 

#b. The p-value tells us the probability of observing the test statistic assuming 
# null hypothesis (mu) is true. The 95% confidence interval tells us the range in 
# which the mean lies with 95% conductibility. If confidence interval does not include 
# mu, than the proposed mu is significantly incorrect. 



# QUESTION 5: Linear Regression 
Score <- c(82, 88, 91, 79, 85, 90, 76, 84, 83, 77)
Hours_Studied <- c(10, 12, 15, 8, 11, 14, 6, 10, 9, 7)
Attendance <- c(90, 95, 97, 85, 92, 96, 80, 89, 88, 84)

Regression_model = lm(Score ~ Hours_Studied + Attendance)
summary(Regression_model) # Output: Call:
                                    #lm(formula = Score ~ Hours_Studied + Attendance)
                                    
                                    #Residuals:
                                      #Min       1Q   Median       3Q      Max 
                                    #-1.43105 -0.43243 -0.07768  0.57539  1.37359 
                                    
                                    #Coefficients:
                                                  #Estimate  Std. Error t value Pr(>|t|)  
                                    #(Intercept)    39.8367    19.8259   2.009   0.0845 .
                                    #Hours_Studied   1.0747     0.5389   1.994   0.0864 .
                                    #Attendance      0.3650     0.2808   1.300   0.2349  
                                    #---
                                      #Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1
                                    
                                    #Residual standard error: 0.9901 on 7 degrees of freedom
                                    #Multiple R-squared:  0.9717,	Adjusted R-squared:  0.9636 
                                    #F-statistic: 120.2 on 2 and 7 DF,  p-value: 3.813e-06

#b. 
# Intercept = 39.8367 
# Hours_Studied = 1.0747 
# Attendance = 0.3650 

# For this study, intercept is the base score (if hour_studies = 0 and attendance = 0), 
# than for every extra hour of studying increase the predicted score by 1.0747 and for 
# every 1% increase in attendance increase predicted score by 0.3650. 

#c. 
#Multiple R-Squared = 0.9717 (97%)
#Adjusted R-Squared = 0.9636 (96%)

# Based on the data this model is a good fit, because the model explains 97% of exam 
# variance, and even when adjusted for a number of predictors it is still 96%.  







