methods = ["rus","smote","smoteenn","smotetomek"]
k=3

projectNames = [
            "Ant",
            "ArgoUML",
            "Columba",
            "EMF",
            "Hibernate",
            "JEdit",
            "JFreeChart",
            "JMeter",
            "JRuby",
            "SQuirrel",
            "Dubbo",
            "Gradle",
            "Groovy",
            "Hive",
            "Maven",
            "Poi",
            "SpringFramework",
            "Storm",
            "Tomcat",
            "Zookeeper"]


comments = []
labels = []
projects = []

for i in range(len(projectNames)):
    with open(methods[k]+"//"+projectNames[i]+"//data.txt", "r", encoding="utf-8") as file:
        lines = file.readlines()
        lines[-1] = lines[-1] + "\n"
    print(projectNames[i]+"comments:"+str(len(lines)))
    comments = comments + lines
    file.close()

    with open(methods[k]+"//"+projectNames[i]+"//label.txt", "r", encoding="utf-8") as file:
        lines = file.readlines()
        lines[-1] = lines[-1] + "\n"
    print(projectNames[i]+"labels:"+str(len(lines)))
    labels = labels + lines

    file.close()

    projects = projects + [projectNames[i]+"\n"] * len(lines)

    print(len(comments))
    print(len(labels))
    print(len(projects))


with open(methods[k]+"\\comments", "w", encoding="utf-8") as file:
    for line in comments:
        file.write(line)
file.close()

with open(methods[k]+"\\labels", "w", encoding="utf-8") as file:
    for line in labels:
        file.write(line)

with open(methods[k]+"\\projects", "w", encoding="utf-8") as file:
    for line in projects:
        file.write(line)