#from collections import defaultdict
import gdown

url = "https://drive.google.com/uc?id=1l_5RK28JRL19wpT22B-DY9We3TVXnnQQ"
output = "fcn8s_from_caffe.npz"
gdown.download(url, output)


input = "Apples - 3 \nbananas-1 \napples - 2 \nGrapes - two  \n paper towels - 1 \nBANANAS - 4 \nPIKACHUS - -1"
invalidLines = 0

#print(input)
#print(input.indexOf("\n"))
def sortList(listOfStuff):
    #split string into array based on spaces
    

    name0 = input.split(" \n") #splits based on n, creates array

    name1 = [item.strip() for item in name0] #same array as name0 but with each value stripped
    name2 = [item2.split("-") for item2 in name1] #array of arrays split by "-"
    name3 = []
    for sublist in name2: #flattens name2 into name3 - extends each sublist onto the larger list
        name3.extend(sublist)
    for i in range(len(name3)): #makes everything lowercase and strips again?

        name3[i] = name3[i].lower().strip()

    things = defaultdict(int) #hashmap
    invalidLines = 0 #count of invalid lines
    for j in range(0, len(name3)-1, 2): #goes through the list of everything by 2 indexes each
        if name3[j] in things and type(name3[j]) == str: #if the object is already in the map just add to what's there
            things[name3[j]] = int(things[name3[j]]) + int(name3[j+1])
        else:
            try:  
                if int(name3[j+1]) < 0: #if the count is less than zero (negative amount) is illegal, continue
                    j+=1
                    invalidLines+=1
                else: #else assign name of object as key and number of objects as value
                    things[name3[j]] = int(name3[j+1])
            except ValueError: #if invalid THING, continue
                j+=1
                invalidLines+=1
    things2 = sorted(things.items(), key = lambda x: x[1]) #sort by value
    things3 = sorted(things2) #sort by name

    answer = ""
    for item in things3: #put everything into a string
        answer = answer + item[0] + ": " + str(item[1]) + "\n"
    answer = answer + "Invalid lines: " + str(invalidLines)
    return answer
print(sortList(input))

        