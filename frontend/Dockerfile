# Step 1: Use official nginx image
FROM nginx:alpine

# Step 2: Remove default static site files
RUN rm -rf /usr/share/nginx/html/*

# Step 3: Copy your frontend files to Nginx's static directory
COPY ./frontend/ /usr/share/nginx/html/

# Step 4: Expose port (optional - handled in docker-compose usually)
EXPOSE 80
