Last week we translated a JSON response into some Java objects.  This week we will take a CSV where each line represents a potential Java object.  We did this in class on Tuesday.  We will do it again today.  This time, our focus will be avocado prices.  Yes, avocado prices.

Background

Refer to this link here from Kaggle.com.  Kaggle holds a trove of data set that are publicly available.  You should look around, there are many data sets that might be interesting to you.  We will review this data set specifically.

https://www.kaggle.com/datasets/neuromusic/avocado-prices/data

What a neat data set.  The prices of avocados and sales regionally across the U.S.  The data set has been uploaded to the /userdata folder of this lab as the CSV file.  CSV stands for comma separated values.

Tasks

Task 1:  Create the Avocado.java Class

You will turn the CSV file into Avocado.java objects and store them in an ArrayList.  Here is the UML diagram for the Avocado class you will create.  Do not be intimidated - it looks like a lot but it simply matches the columns of the CSV file.  The constructor is pretty big:



Be sure to implement all the getters in this class!  One has been implemented for you as an example.  Note - it returns 0.0 and that will need to be changed.

2. Implement AvocadoDriver.java Class:

AvocadoDriver.java performs the following:

1. It reads the CSV file in.

2. It iterates through the CSV a row at a time.

3. It splits each row based on a comma (,) - placing the line into a String[] array.

4. At that point, you have it split into the arguments you need for the constructor.  With a few warnings.  First, you need to consider the header row - you do not want to construct an Avocado object for that!  The 'header row' is the one that contains the column names.  Second, the first column of the CSV is not use in construction of an Avocado object.  You need to be aware of that.

3. Submit and Run Tests

If you do the above - you can submit and run the tests.  You need to get them to pass!



