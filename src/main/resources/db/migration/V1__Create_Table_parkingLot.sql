CREATE TABLE `parking_lot`(
    `id` int auto_increment primary key,
    `name` varchar (255) not null,
    `capacity` int not null,
    `address` varchar (1024)
)