# Base image
FROM node:14-slim 

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the entire React app
COPY . .

# Build the React app
RUN npm run build

# Set the command to run the React app
CMD ["npm", "start"]
