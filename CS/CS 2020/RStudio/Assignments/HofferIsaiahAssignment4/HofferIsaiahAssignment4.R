# ASSINGMENT 4 

# QUESTION 1: COFFEE SHOP 
Caffeine_levels = c(94.2, 95.1, 95.6, 93.9, 96.0, 94.8, 95.5, 95.3, 94.6, 94.9,
                    95.0, 93.7, 94.5, 95.4, 96.3, 95.2, 93.8, 94.0, 94.3, 94.7,
                    95.6, 96.1, 93.6, 94.4, 95.1, 94.2, 96.4, 93.9, 94.3, 95.0)

#   Hypothesis: 
#Null Hypothesis: Caffeine level mean equals 95mg ( mu = 95)

#Alternate Hypothesis: Caffeine levels mean does not equal 95mg ( mu != 95)

# The appropriate test for this sample set is the one-sample t-test. One reason is 
# because the sample size is relatively small (30), another is the fact that the standard
#deviation is unknown, making some methods impossible to use. 

# Executing one-sample t-test with mu = 95
t.test(Caffeine_levels, mu = 95) #Output: One Sample t-test

                                         #data:  Caffeine_levels
                                         #t = -1.0626, df = 29, p-value = 0.2967
                                         #alternative hypothesis: true mean is not equal to 95
                                         #95 percent confidence interval:
                                            #94.55155 95.14179
                                         #sample estimates:
                                           #mean of x 
                                         #94.84667 

#CONCLUSTION 
#Since alpha equals 0.05 and p-value equals 0.2967, we cannot reject the null 
#hypothesis because p-value > alpha (0.2967 > .05). The coffee shop's claim was 
#proven to be true by the one-sample t-test 



#QUESTION 2: ONLINE VS IN-STORE SALES 
Online_Sales <- c(905, 912, 889, 873, 940, 901, 925)
Instore_Sales <- c(891, 879, 900, 890, 902, 880, 888)

# The appropriate test used for this data would be the paired t-test. The paired 
#t-test allowes us to compare pairs of data, which we were given. This test will compare
#each in-store day with each online day. 

#   Hypothesis: 
#Null Hypothesis: There is no difference in mean sales between online and in-store ( mu = 0)

#Alternative Hypothesis: There is a difference in mean sales between online and in-store ( mu != 0)

t.test(Online_Sales,Instore_Sales, paired = TRUE) #Output: Paired t-test

                                                 #data:  Online_Sales and Instore_Sales
                                                 #t = 1.9248, df = 6, p-value = 0.1026
                                                 #alternative hypothesis: true mean difference is not equal to 0
                                                 #95 percent confidence interval:
                                                   #-4.456411 37.313554
                                                 #sample estimates:
                                                   #mean difference 
                                                           #16.42857 


#CONCLUSTION:
#While there is a mean difference on 16.42857, the p-value (0.1026) indicates that this 
# difference is not that significant at the 95% level. Since the p-value is bigger than
#alpha (0.05) we cannot reject the null hypothesis. Also to note, is that the confidence 
# interval contains 0, meaning the mean difference of ~16.4 should not be taken will 100%
# certainty 




#QUESTION 3: COMPARING TEACHING METHODS 
Method1 <- c(88, 90, 85, 87, 91)
Method2 <- c(78, 82, 80, 79, 77)
Method3 <- c(85, 86, 87, 84, 83)


# Hypothesis: 
# Null Hypothesis: The mean test scores are equal on all three teaching methods ( mu1 = mu2 = mu3)

# Alternative Hypothesis: The mean test scores differ is at least one teaching method 
#                           ( mu1 != mu2 = mu3) or ( mu1 = mu2 != mu3 ) or ( mu1 = mu3 != mu2)


#Combining Data 
Exam_scores = c(Method1,Method2,Method3)
method = factor(rep(c("Method1", "Method2", "Method3"), each = 5))
df = data.frame(Exam_scores, method)

# Running one-way ANOVA 
Anova_result = aov(Exam_scores ~ method, data =df)
summary(Anova_result) #Output:              Df Sum Sq Mean Sq F value Pr(>F)    
                              #method       2  208.1  104.07   26.23 4.16e-05 ***
                              #Residuals   12   47.6    3.97                     
                              #---
                              #Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1


#P-Value is significantly different ( < .05), find method that differs. 

#To find what method differs after using ANOVA, I would use TukeyHSD to split up 
# each method, and compare then to each other. This will let me know what two methods differ 
# the most between each other. 

# Finding What Method Differs 
TukeyHSD(Anova_result) #Output:  Tukey multiple comparisons of means
                                  #95% family-wise confidence level
                                  
                              #Fit: aov(formula = Exam_scores ~ method, data = df)
                                  
                              #$method
                                              #diff       lwr      upr     p adj
                              #Method2-Method1 -9.0 -12.36052 -5.63948 0.0000324
                              #Method3-Method1 -3.2  -6.56052  0.16052 0.0624803
                              #Method3-Method2  5.8   2.43948  9.16052 0.0016216

# TukeyHSD showed that their is a major difference between method 1 and 2, with 1 being higher. 
# Method 3 also differs lower than method 1. Lastly method 2 is a difference between method 3, also lower 

